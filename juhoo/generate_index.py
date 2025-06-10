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

| No.   | Title          | Site  | Level              | Code | Review |
|-------|----------------|--------|---------------------|------|--------|
"""

rows = []

for filename in sorted(os.listdir(CODE_DIR)):
    match = re.match(r'(B_B\d)_(\d+)_([a-zA-Z0-9_]+)\.java', filename)

    if match:
        level, num, title = match.groups()
        print(f"[DEBUG] matched: {filename} → {num}, {title}")

        markdown = f'| {num} | {title} | 🟥 백준 | 🟫 {level[4:]} | [📄](./{CODE_DIR}/{filename}) | [📝](./{REVIEW_DIR}/{filename.replace(".java", ".md")}) |'
        rows.append(markdown)

with open(OUTPUT_FILE, 'w', encoding='utf-8') as f:
    f.write(header)
    f.write('\n'.join(rows))
    f.write("\n\n</br>\n\n## 🛠 Tech Stack\n\n")
    f.write('[![Language: Java](https://img.shields.io/badge/Language-Java-007396?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.java.com/)\n')
