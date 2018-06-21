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
}
