package Default;

public class settlement 
{
	// VARIABLES - Buildings
    public int houses;
    public boolean workshop;

    // VARIABLES - Starting Resources
    public int Wood;
    public int Metal;
    public int Food;
    public int Meds;
    public int Ammo;

    public void setSettlement()
    {
        houses = 1;
        workshop = false;
        Wood = 0;
        Metal = 0;
        Food = 40;
        Meds = 0;
        Ammo = 5;
    }
}
