#This will not run on online IDE 
import requests 
from bs4 import BeautifulSoup 
import os

URL = "http://10.10.8.70:8000/Question_Paper/TE_QP/TE/TE%202015/" 
file = "te2015"

os.makedirs(f"/home/pict/31282/chat/{file}", exist_ok=True)
r = requests.get(URL) 

soup = BeautifulSoup(r.content, 'html5lib')

list = []
for a in soup.find_all('a'):    
    list.append(a['href'])

link = list[5:]
print(link)
for l in link:
    r = requests.get(URL+l, stream=True)
    chunk_size = 3000
    with open(f'/home/pict/31282/chat/{file}/{l}', 'wb+') as fd:
        for chunk in r.iter_content(chunk_size):
            fd.write(chunk)
    print("DONE")