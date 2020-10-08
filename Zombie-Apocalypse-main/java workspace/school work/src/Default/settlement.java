package Default;

public class Settlement 
{
	// VARIABLES - Buildings
    public int houses;
    public boolean workshop;

    // VARIABLES - Starting Resources
    public int wood;
    public int metal;
    public int food;
    public int meds;
    public int ammo;

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
