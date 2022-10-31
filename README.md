# Testide koostamise reeglid:
• Testida tuleb liisingu kuumakse kalkulaatorit;

• Koostada tuleb nii manuaalsed testlood kui ka automaatsed testid. Kui palju teste vaja
koostada on, on sinu enda otsustada;

• Põhjenda lühidalt, milliste kriteeriumite alusel ja miks sa just antud testide komplektid
koostasid;

• Manuaalsete testide vormi võid ise valida – oluline on, et testlugudest oleks aru saada, mida
ja miks sa testinud oled.

• Automaatsete testide tegemiseks võid vahendi (raamistiku) samuti vabalt valida, aga see
võiks olla Java-põhine. Kasutada võid näiteks Selenide raamistikku (http://selenide.org/).
Eesmärgiks on teada saada, kas sa ka koodi tasemel teste hallata suudad. Record/playback
vahendite (näiteks Selenium IDE) kasutamine lubatud ei ole;


• Automaatsete testide projekti võiksid saata Giti lingina.


//
- report
- CI jenkins/github actions
- tests
- container

Selenide examples: TODO MVC
================================

This is a sample project demonstrating how to test [TODO MVC application](http://todomvc.com/).

**You can checkout and run it locally with a few minutes.**

### How to run with Gradle

Type from command line to run tests on your machine:

```
./gradlew test
# or
./gradlew test -Dselenide.headless=true
```