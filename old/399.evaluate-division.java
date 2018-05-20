package old;

class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        double[] result = new double[queries.length];
        Map<String, Double> relation_map = new HashMap<String, Double>();
        Double base = 100.0;
        for(int i = 0;i < equations.length ;i++){
            String [] eq = equations[i];
            
            if(!relation_map.containsKey(eq[0]) && !relation_map.containsKey(eq[1])){
                relation_map.put(eq[0],base);
                relation_map.put(eq[1],base/values[i]);
            }
            else if(!relation_map.containsKey(eq[0]) && relation_map.containsKey(eq[1])){
                relation_map.put(eq[0],relation_map.get(eq[1])*values[i]);
            }
            
            else if(relation_map.containsKey(eq[0]) && !relation_map.containsKey(eq[1])){
                relation_map.put(eq[1],relation_map.get(eq[0])/values[i]);
            }
        }

        for (Map.Entry<String, Double> entry : relation_map.entrySet()) {
            System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
        }

       for(int j = 0;j < queries.length ;j++){
            Double prev, next;
            if(relation_map.containsKey(queries[j][0]))
               prev = relation_map.get(queries[j][0]);
            else
               prev = (double)-1;
               
            if(relation_map.containsKey(queries[j][1]))
               next = relation_map.get(queries[j][1]);
            else 
               next = (double)-1;

            System.out.println(queries[j][0]);
            System.out.println(queries[j][1]);
            System.out.println(prev);
            System.out.println(next);
            System.out.println((double)prev/next);

            if(prev == -1 || next == -1)
               result[j] = (double)-1;
            else
               result[j] = prev/next;
        }
        return result; 
    }
}
