import os
import re
from collections import defaultdict

CODE_DIR = 'code'
REVIEW_DIR = 'review'
OUTPUT_FILE = 'README.md'

# 헤더
header = """# 🧠 Juhoo's Algorithm Archive

- 📂 `code/` : 문제별 Java 코드
- 📂 `review/` : 풀이 / 회고 마크다운

</br>

## 📎 Velog
[![Velog](https://img.shields.io/badge/Velog-Bluewave-20c997?style=for-the-badge&logo=velog&logoColor=white)](https://velog.io/@bluemango0312/posts)

</br>

## 🧾 Index
"""

# 티어 약어 → 뱃지 + 이름
level_map = {
    'B': '🟫 Bronze',
    'S': '🟪 Silver',
    'G': '🟨 Gold',
    'P': '⬜ Platinum',
    'D': '⬛ Diamond'
}

# 티어 우선순위 (높을수록 앞)
tier_priority = ['⬛ Diamond', '⬜ Platinum', '🟨 Gold', '🟪 Silver', '🟫 Bronze']

# 티어별 row 그룹화
grouped_rows = defaultdict(list)

for filename in sorted(os.listdir(CODE_DIR)):
    match = re.match(r'B_([BSGPD])(\d)_(\d+)_([a-zA-Z0-9_]+)\.java', filename)
    if match:
        tier, level_num, num, title = match.groups()
        level_label = f"{level_map[tier]} {level_num}"
        tier_group = level_map[tier]

        row = f'| {num} | {title} | 🟥 백준 | {level_label} | [📄](./{CODE_DIR}/{filename}) | [📝](./{REVIEW_DIR}/{filename.replace(".java", ".md")}) |'
        grouped_rows[tier_group].append((int(num), row))

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
    readme_lines.append('\n| No. | Title | Site | Level | Code | Review |')
    readme_lines.append('|-----|-------|------|-------|------|--------|')

    for _, row in sorted(grouped_rows[tier]):
        readme_lines.append(row)

    readme_lines.append('</details>\n')

# Footer
readme_lines.append("\n</br>\n\n## 🛠 Tech Stack\n")
readme_lines.append('[![Language: Java](https://img.shields.io/badge/Language-Java-007396?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.java.com/)')

# 저장
with open(OUTPUT_FILE, 'w', encoding='utf-8') as f:
    f.write('\n'.join(readme_lines))
