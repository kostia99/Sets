package sets;

interface Clonable extends Cloneable {

    /* In order to be able to use clone() everywhere it is overridden with
       a public version.
    */

    public Object clone();

}
