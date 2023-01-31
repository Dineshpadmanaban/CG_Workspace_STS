package hashmap;

	import java.util.HashMap;

	import java.util.Map;

	import java.util.TreeMap;

	public class person
	{

	public HashMap<String, Integer> list = new HashMap<String,Integer>();

	static TreeMap<String,Integer>sort=new TreeMap<>();

	public Boolean valueInHasMap() 
	{
	list.put("Sandy", 22);
	list.put("Sandip",25);
	list.put("Muruga",23);
	list.put("Ramu",24);
	return list.isEmpty();
	}
	public int calculateAge(Map<String,Integer> person)
	{
	int sum = 0;
	for (int value: person.values())
	{
	sum += value;
	}
	return sum;
	}
	static void Sorting(Map<String,Integer> person)
	{
	sort.putAll(person);
	for (Map.Entry<String, Integer> entry : sort.entrySet())
	System.out.println("Key = " + entry.getKey() +", Value = " + entry.getValue());
	}
	public static void main(String[] args)
	{
	person hmc = new person();
	System.out.print(hmc.valueInHasMap());
	System.out.println(hmc.list);
	person.Sorting(hmc.list);
	hmc.calculateAge(hmc.list);
	}
	}

	 