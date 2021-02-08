package TireMall.Commands;

public class State {

    Command redo;
    Command undro;

    public State(Command r, Command u) {
        this.redo = r;
        this.undro = u;
    }
}
// TODO

/*
* IFALL DET INTE FUNGERAR JAG SKULLE REFACTORERA INTERFACET TILL EN CLASS
* KOLLA PÅ FÖRSTA FÖRELÄSNING PRECIS EFTER FÖRSTA PAUS
* */