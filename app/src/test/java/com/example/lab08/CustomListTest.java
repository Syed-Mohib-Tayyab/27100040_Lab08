package com.example.lab08;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class CustomListTest {
    @Test
    public void testHasCity() {
        CustomList list = new CustomList();
        City calgary = new City("Calgary", "AB");
        list.addCity(calgary);
        // This will fail initially because hasCity() doesn' exist
        assertTrue(list.hasCity(calgary));
    }

    @Test
    public void testDelete() {
        CustomList list = new CustomList();
        City calgary = new City("Calgary", "AB");

        // Add the city and verify it's there
        list.addCity(calgary);
        assertTrue(list.hasCity(calgary));

        // Delete the city and verify it's gone
        list.delete(calgary);
        assertFalse(list.hasCity(calgary));
    }

    @Test
    public void testDeleteException() {
        CustomList list = new CustomList();
        City calgary = new City("Calgary", "AB");

        // Attempt to delete a city that wasn't added, expecting an exception
        assertThrows(IllegalArgumentException.class, () -> {
            list.delete(calgary);
        });
    }

    @Test
    public void testCountCities() {
        CustomList list = new CustomList();

        assertEquals(0, list.countCities());

        City calgary = new City("Calgary", "AB");
        list.addCity(calgary);
        assertEquals(1, list.countCities());
    }
}
