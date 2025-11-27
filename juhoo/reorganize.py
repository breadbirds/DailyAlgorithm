import os
import re
from pathlib import Path

CODE_DIR = Path("code")

pattern = re.compile(r'B_([BSGPD])(\d)_(\d+)_([a-zA-Z0-9_]+)\.java')

tier_dir_map = {
    'B': 'bronze',
    'S': 'silver',
    'G': 'gold',
    'P': 'platinum',
    'D': 'diamond',
}

for file in CODE_DIR.glob("*.java"):
    m = pattern.match(file.name)
    if not m:
        print("skip:", file.name)
        continue

    tier_char = m.group(1)
    subdir = CODE_DIR / tier_dir_map[tier_char]
    subdir.mkdir(exist_ok=True)

    new_path = subdir / file.name
    print(f"move {file} -> {new_path}")
    file.rename(new_path)
