package myDecks;

import java.util.ArrayList;

public interface Common<T> {

    /**
     * initial a game
     */
    public void setUp();


    /**
     * print all objects
     */
    public void printAll();


    /**
     * shuffle all objects
     */
    public void shuffle();


    /**
     * add a new object
     * @param object a new object need to be added
     */
    public void addWith(T object);


    /**
     * remove the first object
     * @return an object removed
     */
    public T removeTopOne();


    /**
     * sort objects in specific order
     */
    public void sortAll();

}
