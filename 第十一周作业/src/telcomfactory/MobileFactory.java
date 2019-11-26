package telcomfactory;
import telcom.Mobile;
import telcom.Telcom;
import user.*;
public class MobileFactory {
	public Telcom createTelcom() {
		return (Telcom) new Mobile();
	}
}
