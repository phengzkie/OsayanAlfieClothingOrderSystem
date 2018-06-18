import java.util.ArrayList;

public class ClothesCollection
{
	private ArrayList<Clothes> clothes;

	public ClothesCollection() {
		clothes = new ArrayList<Clothes>();
	}

	public void addClothes(Clothes clothe) {
		clothes.add(clothe);
	}

	public void removeClothes(Clothes clothe) {
		clothes.remove(clothe);
	}

	public ArrayList<Clothes> getAllClothes() {
		return(clothes);
	}

	public Clothes getClothesByIndex(int n) {
		return(clothes.get(n));
	}

	public int getClothesCount() {
		return(clothes.size());
	}

	// public ArrayList<Asset> search(String s) {
	// 	Asset a = null;
	// 	ArrayList<Asset> al = new ArrayList<Asset>();
	// 	String str = s.toLowerCase();
	// 	for(int i=0; i<getAssetCount(); i++) {
	// 		a = getAssetByIndex(i);
	// 		if(matches(a, str)) {
	// 			al.add(a);
	// 		}
	// 	}
	// 	return(al);
	// }

	// public boolean matches(Asset a, String str) {
	// 	String name = a.getName().toLowerCase();
	// 	int monetaryValue = a.getMonetaryValue();
	// 	String ab = Integer.toString(monetaryValue);
	// 	if(ab.contains(str) || name.contains(str)) {
	// 		return(true);
	// 	}
	// 	return(false);
	// }
}
