import os
import re

CODE_DIR = 'code'
REVIEW_DIR = 'review'
OUTPUT_FILE = 'README.md'

header = """# 🧠 Juhoo's Algorithm Archive

- 📂 `code/` : 문제별 Java 코드
- 📂 `review/` : 풀이 / 회고 마크다운

</br>

## 📎 Velog
[![Velog](https://img.shields.io/badge/Velog-Bluewave-20c997?style=for-the-badge&logo=velog&logoColor=white)](https://velog.io/@bluemango0312/posts)

</br>

## 🧾 Index

| No.   | Title          | Site  | Level        | Code | Review |
|-------|----------------|--------|--------------|------|--------|
"""

# 레벨 약어 → 뱃지 매핑
level_map = {
    'B': '🟫 Bronze',
    'S': '🟪 Silver',
    'G': '🟨 Gold',
    'P': '⬜ Platinum',
    'D': '⬛ Diamond'
}

rows = []

for filename in sorted(os.listdir(CODE_DIR)):
    match = re.match(r'B_([BSGPD])(\d)_(\d+)_([a-zA-Z0-9_]+)\.java', filename)

    if match:
        tier, level_num, num, title = match.groups()
        level_str = f"{level_map.get(tier, '❓')} {level_num}"

        print(f"[DEBUG] matched: {filename} → {num}, {title}, {level_str}")

        markdown = f'| {num} | {title} | 🟥 백준 | {level_str} | [📄](./{CODE_DIR}/{filename}) | [📝](./{REVIEW_DIR}/{filename.replace(".java", ".md")}) |'
        rows.append(markdown)

with open(OUTPUT_FILE, 'w', encoding='utf-8') as f:
    f.write(header)
    f.write('\n'.join(rows))
    f.write("\n\n</br>\n\n## 🛠 Tech Stack\n\n")
    f.write('[![Language: Java](https://img.shields.io/badge/Language-Java-007396?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.java.com/)\n')
