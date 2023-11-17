package adt.heap.extended;

import adt.heap.ComparatorMaxHeap;
import adt.heap.ComparatorMinHeap;
import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;

public class FloorCeilHeapImplTest {

    private FloorCeilHeapImpl floorCeilHeap;
    private final Comparator<Integer> comparator = new ComparatorMinHeap<>();

    @Before
    public void criaClasse () { this.floorCeilHeap = new FloorCeilHeapImpl(comparator); }

    public void verificaFloor (Integer[] array, int x, Integer retornoEsperado) {
        this.criaClasse();
        assertEquals(retornoEsperado, floorCeilHeap.floor(array, x));
    }

    public void verificaFloor (Integer[] array, int x, int retornoEsperado) {
        this.criaClasse();
        assertEquals(Integer.valueOf(retornoEsperado), floorCeilHeap.floor(array, x));
    }

    public void verificaCeil (Integer[] array, int x, Integer retornoEsperado) {
        this.criaClasse();
        assertEquals(retornoEsperado, floorCeilHeap.ceil(array, x));
    }

    public void verificaCeil (Integer[] array, int x, int retornoEsperado) {
        this.criaClasse();
        assertEquals(Integer.valueOf(retornoEsperado), floorCeilHeap.ceil(array, x));
    }

    // Testes floor

    @Test
    public void testFloorXMenorQueTodoArray () {
        Integer[] array = new Integer[]{4,15,25,30,38,84,96};

        verificaFloor(array, 3, null);
        verificaFloor(array, 2, null);
        verificaFloor(array, 1, null);
        verificaFloor(array, 0, null);
        verificaFloor(array, -1, null);
        verificaFloor(array, -2, null);
        verificaFloor(array, -3, null);
    }

    @Test
    public void testFloorArrayOrdenado () {
        Integer[] array = new Integer[]{4,15,25,30,38,84,96};

        verificaFloor(array, 38, 38);
        verificaFloor(array, 17, 15);
        verificaFloor(array, 200, 96);
        verificaFloor(array, 60, 38);
    }

    @Test
    public void testFloorArrayNaoOrdenado () {
        Integer[] array = new Integer[]{25,38,15,96,4,30,84};

        verificaFloor(array, 38, 38);
        verificaFloor(array, 17, 15);
        verificaFloor(array, 200, 96);
        verificaFloor(array, 60, 38);
    }

    @Test
    public void testFloorArrayComUmElemento () {
        Integer[] array = new Integer[]{2};

        verificaFloor(array, 1, null);
        verificaFloor(array, 2, 2);
        verificaFloor(array, 3, 2);
        verificaFloor(array, 100, 2);
        verificaFloor(array, 100000, 2);
    }

    @Test
    public void testFloor01 () {
        Integer[] array = new Integer[]{-2,0,4,6,8,10,94,96,102};

        verificaFloor(array, 1, 0);
        verificaFloor(array,-1, -2);
        verificaFloor(array, 5, 4);
        verificaFloor(array, 6, 6);
    
    }

    @Test
    public void testFloor02 () {
        Integer[] array = new Integer[]{-8,-4,-2,0,5,8,12,58,87,174};
        verificaFloor(array, -1, -2);
        verificaFloor(array, 1, 0);
        verificaFloor(array, 6, 5);
        verificaFloor(array, 9, 8);

    }

    // testes Ceil

    @Test
    public void testCeilXMaiorQueTodoArray () {
        Integer[] array = new Integer[]{4,15,25,30,38,84,96};

        verificaCeil(array, 97, null);
        verificaCeil(array, 98, null);
        verificaCeil(array, 99, null);
        verificaCeil(array, 100, null);
    }

    @Test
    public void testCeilArrayOrdenado () {
        Integer[] array = new Integer[]{4,15,25,30,38,84,96};

        verificaCeil(array, 38, 38);
        verificaCeil(array, 17, 25);
        verificaCeil(array, 200, null);
        verificaCeil(array, 60, 84);
    }

    @Test
    public void testCeilArrayNaoOrdenado () {
        Integer[] array = new Integer[]{25,38,15,96,4,30,84};

        verificaCeil(array, 38, 38);
        verificaCeil(array, 17, 25);
        verificaCeil(array, 200, null);
        verificaCeil(array, 60, 84);
    }

    @Test
    public void testCeilArrayComUmElemento () {
        Integer[] array = new Integer[]{2};

        verificaCeil(array, 1, 2);
        verificaCeil(array, 2, 2);
        verificaCeil(array, 3, null);
        verificaCeil(array, 100, null);
    }

    @Test
    public void testCeil01 () {
        Integer[] array = new Integer[]{-2,0,4,6,8,10,94,96,102};

        verificaCeil(array, 1, 4);
        verificaCeil(array, 0, 0);
        verificaCeil(array, 9, 10);
        verificaCeil(array, 1000, null);

    }

    @Test
    public void testCeil02 () {
        Integer[] array = new Integer[]{-8,-4,-2,0,5,8,12,58,87,174};
        verificaCeil(array, -3, -2);
        verificaCeil(array, 0, 0);
        verificaCeil(array, 1, 5);
        verificaCeil(array, 6, 8);
        verificaCeil(array, 175, null);
    }

}