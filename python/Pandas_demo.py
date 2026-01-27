import pandas as pd

data = {
    "X": [1, 2, 3, 4, 5],
    "Y": [3, 4, 5, 6, 7],
    "Z": [2, 4, 7, 7, 8]
}

df = pd.DataFrame(data)
print(df)