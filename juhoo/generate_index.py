import os
import re
from collections import defaultdict
import subprocess
from datetime import datetime

CODE_DIR = 'code'
OUTPUT_FILE = 'README.md'

# 헤더
header = """# 🧠 Juhoo's Algorithm Archive

- 📂 `code/` : 문제별 Java 코드

</br>

## 📎 Velog
[![Tistory](https://img.shields.io/badge/Tistory-Bluemang0-FF5A4A?style=for-the-badge&logo=tistory&logoColor=white)](https://bluemang0.tistory.com/)
[![Velog](https://img.shields.io/badge/Velog-Bluewave-20c997?style=for-the-badge&logo=velog&logoColor=white)](https://velog.io/@bluemango0312/posts)

</br>

## 🧾 Index
"""

# 티어 약어 → 뱃지 + 이름
level_map = {
    'B': '🤎 Bronze',
    'S': '🩶 Silver',
    'G': '💛 Gold',
    'P': '🤍 Platinum',
    'D': '💚 Diamond'
}

# git commit 날짜 가져오기
def get_git_modified_date(file_path):
    try:
        result = subprocess.check_output(
            ['git', 'log', '-1', '--format=%ad', '--date=short', file_path],
            stderr=subprocess.DEVNULL
        )
        return result.decode('utf-8').strip()
    except:
        return 'N/A'

# 티어 표시 우선순위(상위 티어 먼저)
tier_priority = ['💚 Diamond', '🤍 Platinum', '💛 Gold', '🩶 Silver', '🤎 Bronze']

# 티어별 row 그룹화
grouped_rows = defaultdict(list)

pattern = re.compile(r'B_([BSGPD])(\d)_(\d+)_([a-zA-Z0-9_]+)\.java')
for filename in sorted(os.listdir(CODE_DIR)):
    m = pattern.match(filename)
    if not m:
        print(f"❌ Not matched: {filename}")
        continue

    tier_char, level_num, num, title = m.groups()
    level_label = f"{level_map[tier_char]} {level_num}"
    tier_group = level_map[tier_char]

    title_display = title.replace('_', ' ')
    codepath = f"{CODE_DIR}/{filename}"
    date = get_git_modified_date(codepath)

    row = f'| {num} | {title_display} | 🟥 백준 | {level_label} | [📄]({codepath}) | {date} |'
    grouped_rows[tier_group].append((date, row))  # 날짜 기준 정렬용

# 현재 티어 중 가장 높은 것 찾기
available_tiers = [t for t in tier_priority if t in grouped_rows]
highest_tier = available_tiers[0] if available_tiers else None

# README 구성
readme_lines = [header]

for tier in tier_priority:
    if tier not in grouped_rows:
        continue

    tag = "details open" if tier == highest_tier else "details"
    readme_lines.append(f'<{tag}>\n<summary>{tier}</summary>\n')
    readme_lines.append('\n| No. | Title | Site | Level | Code | Date |')
    readme_lines.append('|-----|-------|------|-------|------|------|')

    # 날짜 기준 내림차순
    for _, row in sorted(grouped_rows[tier], key=lambda x: x[0], reverse=True):
        readme_lines.append(row)

    readme_lines.append('</details>\n')

# Footer
readme_lines.append("\n</br>\n\n## 🛠 Tech Stack\n")
readme_lines.append('[![Language: Java](https://img.shields.io/badge/Language-Java-007396?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.java.com/)')

# 저장
with open(OUTPUT_FILE, 'w', encoding='utf-8') as f:
    f.write('\n'.join(readme_lines))
