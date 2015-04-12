package com.abc.example.hashtable.simple;

public class HashMap {

    private final static int size = 128;
    HashEntry[] table;

    public HashMap() {
          table = new HashEntry[size];
          for (int i = 0; i < size; i++)
                table[i] = null;
    }

    public void put(int key, int value) {
        int hash = (key % size);

        while (table[hash] != null && table[hash].getKey() != key)
              hash = (hash + 1) % size;
        
        table[hash] = new HashEntry(key, value);
    }
    
    public int get(int key) {
          int hash = (key % size);

          while (table[hash] != null && table[hash].getKey() != key)
                hash = (hash + 1) % size;

          if (table[hash] == null)
                return -1;
          else
                return table[hash].getValue();
    }

}
