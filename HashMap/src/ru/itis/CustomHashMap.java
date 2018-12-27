package ru.itis;

public class CustomHashMap<K,V>{
    private Entry<K, V>[] table;
    private int capacity = 4;
    static class Entry<K,V> {
        K key;
        V value;
        Entry<K,V> next;

        public Entry(K key, V value, Entry<K, V> next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public CustomHashMap(){
        table = new Entry[capacity];
    }


    public void put(K newKey, V value){
        if (newKey == null){
            return;
        }
        int hash = hash(newKey);

        Entry<K,V> newEntry = new Entry<>(newKey, value, null);
        if (table[hash] == null){
            table[hash] = newEntry;
        } else {
            Entry<K, V> previous = null;
            Entry<K, V> curr = table[hash];
            while(curr!=null){
                if (curr.key.equals(newKey)){
                    if (previous==null){
                        newEntry.next = curr.next;
                        table[hash] = newEntry;
                        return;
                    } else {
                        newEntry.next = curr.next;
                        previous.next = newEntry;
                        return;
                    }
                }
                previous = curr;
                curr = curr.next;
            }
            previous.next = newEntry;
        }
    }

    public V get(K key){
        int hash = hash(key);
        if (table[hash] == null){
            return null;
        } else {
            Entry<K, V> temp = table[hash];
            while(temp!=null){
                if (temp.key.equals(key))
                    return temp.value;
                temp = temp.next;
            }
            return null;
        }
    }

    public boolean remove(K deleteKey){
        int hash = hash(deleteKey);
        if (table[hash]==null){
            return false;
        } else {
            Entry<K,V> previous = null;
            Entry<K,V> curr = table[hash];
            while (curr!=null){
                if (curr.key.equals(deleteKey)){
                    if (previous==null){
                        table[hash] = table[hash].next;
                        return true;
                    } else {
                        previous.next = curr.next;
                        return true;
                    }
                }
                previous = curr;
                curr = curr.next;
            }
            return false;
        }
    }

    public void print(){
        for (int i = 0; i < capacity; i++){
            if (table[i]!=null){
                Entry<K,V> entry = table[i];
                while(entry!=null){
                    System.out.println(entry.key + " " + entry.value);
                    entry = entry.next;
                }
            }
        }
    }


    private int hash(K key){
        return Math.abs(key.hashCode()) % capacity;
    }

}
