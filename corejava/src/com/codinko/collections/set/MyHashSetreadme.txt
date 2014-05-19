/**
 * Aim: Set does not allow duplicates. So if you have a hashset of employee
 * objects with same name and id, then will the Set allow them to be added?
 * 
 * So: Set does not allow duplicates with the help of hashcode() and equals() method
 * Basically when you add an element to Set, it checks if the element is already present.
 * 
 * If you use HashSet, this checking is done like this:
 * It internally make use of hashcode() and equals() to find out.
 The add() method of HashSet -
  public boolean add(E e) {
	return map.put(e, PRESENT)==null;
    }
    
    This map is a HashMap.
    
    If you go inside put(),
    
     public V put(K key, V value) {
        if (key == null)
            return putForNullKey(value);
        int hash = hash(key.hashCode());
        int i = indexFor(hash, table.length);
        for (Entry<K,V> e = table[i]; e != null; e = e.next) {
            Object k;
            if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
                V oldValue = e.value;
                e.value = value;
                e.recordAccess(this);
                return oldValue;
            }
        }
    
    Now you see, it  (1)checks hashcode() and then (2) check if the object references are same [using ==] and then 
     (3) checks equals() if required.
 * 
 * In case of HashSet, when you add or retrieve an element, it checks for both hashcode and equals() method.
   First it check if there exists an element with same hashcode, if not, add it. 
   If it exists, then check if the equals() is returning true for those two objects.
 * 
 
 /**
 Constructor and Description
 
HashSet()
Constructs a new, empty set; the backing HashMap instance has default initial capacity (16) and load factor (0.75).

HashSet(Collection<? extends E> c)
Constructs a new set containing the elements in the specified collection.

HashSet(int initialCapacity)
Constructs a new, empty set; the backing HashMap instance has the specified initial capacity and default load factor (0.75).

HashSet(int initialCapacity, float loadFactor)
Constructs a new, empty set; the backing HashMap instance has the specified initial capacity and the specified load factor.

 */
