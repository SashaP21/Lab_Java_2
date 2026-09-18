@echo off

rem Очистка старых результатов сборки
if exist out rmdir /s /q out

rem Компиляция всех исходников в каталог out
javac -encoding UTF-8 -d out ^
  src\ru\university\lab2\*.java ^
  src\ru\university\lab2\numbers\*.java ^
  src\ru\university\lab2\strings\*.java ^
  src\ru\university\lab2\arrays\*.java ^
  src\ru\university\lab2\util\*.java

if errorlevel 1 (echo Ошибка компиляции & exit /b 1)

rem Сборка исполняемого JAR с манифестом
jar cfm lab2.jar manifest.mf -C out .

echo Done: lab2.jar