import os
import re
from collections import defaultdict, Counter
import subprocess
from datetime import datetime

CODE_DIR = 'code'
OUTPUT_FILE = 'README.md'
MAX_PER_TIER = 30  # 티어별로 README에 보여줄 최대 개수
USE_VELOG_LINK = True  # Velog 링크를 끄고 싶으면 False

# 현재 README 헤더(네가 사용하던 형태 유지)
header = """# 🧠 Juhoo's Algorithm Archive

- 📂 `code/` : 문제별 Java 코드

</br>

## 📎 Velog
[![Tistory](https://img.shields.io/badge/Tistory-Bluemang0-FF5A4A?style=for-the-badge&logo=tistory&logoColor=white)](https://bluemang0.tistory.com/)
[![Velog](https://img.shields.io/badge/Velog-Bluewave-20c997?style=for-the-badge&logo=velog&logoColor=white)](https://velog.io/@bluemango0312/posts)

</br>
"""

# 티어 약어 → 라벨
level_map = {
    'B': '🤎 Bronze',
    'S': '🩶 Silver',
    'G': '💛 Gold',
    'P': '🤍 Platinum',
    'D': '💚 Diamond'
}

# 티어 우선순위
tier_priority = ['💚 Diamond', '🤍 Platinum', '💛 Gold', '🩶 Silver', '🤎 Bronze']

# 파일명 패턴: B_S5_13301_타일장식물.java
# 마지막 제목 부분은 .java 전까지 전부 허용 (한글 포함)
pattern = re.compile(r'B_([BSGPD])(\d)_(\d+)_([^.]+)\.java')


def get_git_first_date(file_path: str) -> str:
    """
    이 파일이 처음 커밋된 날짜를 YYYY-MM-DD 형식으로 가져온다.
    폴더 이동(경로 변경)이 있어도 과거 이력을 따라간다.
    """
    try:
        result = subprocess.check_output(
            [
                'git', 'log',
                '--follow',              # rename 이력 따라가기
                '--format=%ad',
                '--date=short',
                '--', file_path
            ],
            stderr=subprocess.DEVNULL
        )
        lines = result.decode('utf-8').strip().splitlines()
        if not lines:
            return 'N/A'
        # log는 최신 → 과거 순이라, 마지막 줄이 "가장 오래된 커밋 날짜"
        return lines[-1]
    except Exception:
        return 'N/A'


def make_progress_bar(total: int) -> str:
    """progress-bar.dev 형식의 마크다운 이미지 생성."""
    scale = max(total, 100)
    return f"![Solved](https://progress-bar.dev/{total}/?scale={scale}&title=solved&width=300&color=20c997)"


def make_tier_badge(name: str, count: int) -> str:
    """티어 이름과 개수로 뱃지 마크다운 생성."""
    color_map = {
        'Bronze': '9c5221',
        'Silver': 'c0c0c0',
        'Gold': 'd4af37',
        'Platinum': '4fcead',
        'Diamond': '00bcd4',
    }
    pure_name = name.split(' ', 1)[-1]  # "🤎 Bronze" -> "Bronze"
    color = color_map.get(pure_name, '999999')
    return f"![{pure_name}](https://img.shields.io/badge/{pure_name}-{count}-{color}?style=for-the-badge)"


grouped_rows = defaultdict(list)  # tier_label -> list[(date, num, title_display, row)]
tier_counts = Counter()
total_solved = 0
today_str = datetime.now().strftime('%Y-%m-%d')
todays_problems = []

# code/ 아래를 재귀적으로 탐색
for root, _, files in os.walk(CODE_DIR):
    for filename in sorted(files):
        m = pattern.match(filename)
        if not m:
            continue

        tier_char, level_num, num, title = m.groups()
        tier_label = level_map[tier_char]           # 예: "🩶 Silver"
        level_label = f"{tier_label} {level_num}"   # 예: "🩶 Silver 3"

        title_display = title.replace('_', ' ')
        relpath = os.path.join(root, filename).replace('\\', '/')
        date = get_git_first_date(relpath)  # 여기서 "처음 푼 날짜" 기준으로 변경

        if USE_VELOG_LINK:
            velog_url = f"https://velog.io/@bluemango0312/BOJ-{num}"
            title_cell = f"{title_display} [✏️]({velog_url})"
        else:
            title_cell = title_display

        row = f"| {num} | {title_cell} | 🟥 백준 | {level_label} | [📄]({relpath}) | {date} |"

        grouped_rows[tier_label].append((date, num, title_display, row))
        tier_counts[tier_label] += 1
        total_solved += 1

        if date == today_str:
            todays_problems.append((num, title_display, relpath))

available_tiers = [t for t in tier_priority if t in grouped_rows]
highest_tier = available_tiers[0] if available_tiers else None

readme_lines = [header]

# 진행 현황
readme_lines.append("## 📊 Progress\n")
readme_lines.append(make_progress_bar(total_solved))
readme_lines.append("\n")
readme_lines.append(f"Last updated: {today_str}  \n")
readme_lines.append(f"Total solved: {total_solved} problems\n")
readme_lines.append("\n</br>\n")

# 티어 통계
readme_lines.append("## 🎖 Tier Breakdown\n")
for tier in tier_priority:
    if tier_counts[tier] == 0:
        continue
    readme_lines.append(make_tier_badge(tier, tier_counts[tier]) + " ")
readme_lines.append("\n\n</br>\n")

# 오늘 푼 문제
readme_lines.append("## 🌟 Today’s Upload\n")
if todays_problems:
    for num, title_display, path in sorted(todays_problems, key=lambda x: x[0]):
        readme_lines.append(f"- {num} {title_display} ([code]({path}))")
else:
    readme_lines.append("- No commits for today (yet)")
readme_lines.append("\n\n</br>\n")

# Index 헤더
readme_lines.append("## 🧾 Index\n")

# 티어별 상세 목록
for tier in tier_priority:
    if tier not in grouped_rows:
        continue

    tag = "details open" if tier == highest_tier else "details"
    readme_lines.append(f"<{tag}>\n<summary>{tier}</summary>\n")
    readme_lines.append("\n| No. | Title | Site | Level | Code | Date |")
    readme_lines.append("|-----|-------|------|-------|------|------|")

    rows_sorted = sorted(grouped_rows[tier], key=lambda x: x[0], reverse=True)
    for date, num, title_display, row in rows_sorted[:MAX_PER_TIER]:
        readme_lines.append(row)

    if len(rows_sorted) > MAX_PER_TIER:
        more_count = len(rows_sorted) - MAX_PER_TIER
        readme_lines.append(f"| ... | ... | ... | ... | ... | (+{more_count} more) |")

    readme_lines.append("</details>\n")

# Tech Stack
readme_lines.append("\n</br>\n\n## 🛠 Tech Stack\n")
readme_lines.append("[![Language: Java](https://img.shields.io/badge/Language-Java-007396?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.java.com/)\n")

# README 저장
with open(OUTPUT_FILE, 'w', encoding='utf-8') as f:
    f.write('\n'.join(readme_lines))

print("README generated:", os.path.abspath(OUTPUT_FILE))
