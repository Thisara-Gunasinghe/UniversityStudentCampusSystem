@echo off
if not exist out mkdir out
javac -d out src\model\Student.java src\datastructures\*.java src\app\Main.java
if errorlevel 1 (
    echo Compilation failed.
    pause
    exit /b 1
)
echo Compilation successful.
pause
