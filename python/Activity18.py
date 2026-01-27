import pandas as pd 
df = pd.read_csv("users.csv")

print("usernames column:")
print(df["usernames"])
print()

print("Second row (username & Password):")
print(df.iloc[1])
print()

print("sorted by usernames (ascending):")
print(df.sort_values("usernames"))
print()

print("sorted by Passwords (descending):")
print(df.sort_values("Passwords", ascending=False))