import webbrowser

heiro = {"a": "eglypha.jpg", "b": "eglyphb.jpg", "c": "eglyphc.jpg", "d": "eglyphd.jpg", "z": "eglyphz.jpg", "g": "eglyphg.jpg", "h": "eglyphh.jpg", "i": "eglyphi.jpg", 
         "j": "eglyphj.jpg", "k": "eglyphk.jpg", "l": "eglyphl.jpg", "m": "eglyphm.jpg", "n": "eglyphn.jpg", "o": "eglypho.jpg", "p": "eglyphp.jpg", "x": "eglyphx.jpg",
         "q": "eglyphq.jpg", "r": "eglyphr.jpg", "s": "eglyphs.jpg", "t": "eglypht.jpg", "u": "eglyphu.jpg", "w": "eglyphw.jpg", "y": "eglyphy.jpg"}

def egypt(x):
    s = "" #HTML string to return
    new = ""
    for i in range(0, len(x)): # removes the letters that are not supported
        if not x[i] =="e" and not x[i] == "f" and not x[i] == " ":
            new = new + x[i]
    for j in range(0, len(new)):
        if j == 0:
            s = s + "<html><body><h2 class='text-center'>" + x + "-" + new + "</h2><img src='eglyphTOP.jpg'><br><img src='" + heiro[new[j]] + "'><br>"
        elif j > 0 and j < len(new) - 1:
            s = s + "<img src='" + heiro[new[j]] + "'><br>"
        elif j == len(new) - 1:
            s = s + "<img src='" + heiro[new[j]] + "'><br><img src='eglyphBOTTOM.jpg'><br></body></html>"
    return s


plocation = input("Enter location: ")

f = open(plocation,"w")

name = input("Name: ")

f.write(egypt(name))

f.close()
#C:\Users\J\source\repos\C200-Assignments\Assignment7\file.html
webbrowser.open_new_tab(plocation)
