# anvilgui-1.10.13-26.2.jar

latest AnvilGUI on repo.codemc.io is 1.10.10 and it only goes up to 1.21.10. the 26.x wrapper (Wrapper26_R1) is only in the source for now (WesJD/AnvilGUI master c9ba9f5)

so this jar is the api, abstraction and 26_R1 modules from that commit, compiled with javac --release 21 against spigot 26.2. it only has the 26.x wrapper so this build is for 26.x servers

AnvilGUI is MIT licensed, Copyright (c) WesJD, https://github.com/WesJD/AnvilGUI

install it before building:

    mvn install:install-file -Dfile=libs/anvilgui-1.10.13-26.2.jar -DgroupId=net.wesjd -DartifactId=anvilgui -Dversion=1.10.13-26.2 -Dpackaging=jar
