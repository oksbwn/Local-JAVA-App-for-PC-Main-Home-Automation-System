package resources;
import java.awt.Image;
import java.awt.Toolkit;
public class RscLoader {
static RscLoader rl=new RscLoader();
public static Image getImage(String name)
{
	return Toolkit.getDefaultToolkit().getImage(rl.getClass().getResource(name+".jpg"));
	}
}
