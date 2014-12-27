package fr.unice.polytech.si4.complexite;

/**
 * @author mmultari
 * @version 26/12/14.
 */
public class Id {

    // The id's value
    private int value;
    // The id's field.
    private Field field;
    // The id's position in the field.
    private Location location;

    /**
     * Create a new id at location in field.
     *
     * @param value The value of the id
     * @param field The field currently occupied.
     * @param location The location within the field.
     */
    public Id(int value,Field field, Location location)
    {
        this.value=value;
        this.field = field;
        setLocation(location);
    }


    /**
     * Return the id's value
     * @return the id's value
     */
    public int getValue(){
        return value;
    }

    /**
     * Return the id's location.
     * @return The id's location.
     */
    public Location getLocation()
    {
        return location;
    }

    /**
     * Place the id at the new location in the given field.
     * @param newLocation The id's new location.
     */
    public void setLocation(Location newLocation)
    {
        if(location != null) {
            field.clear(location);
        }
        location = newLocation;
        field.place(this, newLocation);
    }

    /**
     * Return the id's field.
     * @return The id's field.
     */
    public Field getField()
    {
        return field;
    }
}
