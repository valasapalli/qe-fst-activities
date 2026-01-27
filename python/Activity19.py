import pandas as pd
data = {
    "FirstName": ["satvik", "Avinash", "lahri"],
    "LastName": ["shah","kati","Rath"],
    "Email": ["satshah@example.com", "avinashk@gmail.com","lahri.rath@example.com"],
    "PhoneNumber": ["4537829158","5892184058","4528727830"]
              
}

df = pd.DataFrame(data)
df.to_excel("users.xlsx", index=False)
print("excel file created successfully")
