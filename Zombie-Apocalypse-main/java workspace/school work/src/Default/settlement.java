package Default;

public class settlement 
{
	// VARIABLES - Buildings
    public static int houses;
    public static boolean workshop;

    // VARIABLES - Starting Resources
    public static int wood;
    public static int metal;
    public static int food;
    public static int meds;
    public static int ammo;

    public void setSettlement()
    {
        houses = 1;
        workshop = false;
        wood = 0;
        metal = 0;
        food = 40;
        meds = 0;
        ammo = 5;
    }
}
