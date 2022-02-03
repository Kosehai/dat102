# Oblig 1

Tester for alt finner du under src/tester, må ha det under src mappen ellers så blir ikkje vscode så glad.

Besvarelse for oppgave 2 ligger i PDF "oppgave2.pdf"

### Gruppe 22.
\
\
i)

### Oppgave 4 besvarelse
```java
Se på de 2 test-metodene under. Hva uttrykker de?

i)
@Test
public void pushPopErTom() {
    try {
        stabel.push(e0);
        stabel.pop();
        assertTrue(stabel.erTom());
    } catch (EmptyCollectionException e) {
        fail("push eller pop feilet uventet " + e.getMessage());
    }
}

ii)
@Test
public void popFromEmptyIsUnderflowed() {
    Assertions.assertThrows(EmptyCollectionException.class, () -> {
        stabel.pop();
    });
}
```
```
På punkt i) legger testen til et element i stacken og popper det ut for å sjekke om stack er tom. Det er også plassert inni try catch blocker og kaller funksjonen fail om det kommen en uventet feil.

På punkt ii) bruker testen Junit sin aseertThrows for å sjekke om funksjonen den kaller kaster en feilmelding.
```