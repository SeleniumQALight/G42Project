@ECHO off
java -jar selenium-server-standalone-2.44.0.jar -role node -nodeConfig nodeconfig.json -Dwebdriver.chrome.driver="..\drivers\chromedriver.exe"
pause 