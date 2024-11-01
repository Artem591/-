@echo offif exist out (
    rmdir /s /q out)
mkdir out
cd srcjavac -d ../out *.java
cd ..
java -cp out Main
pause