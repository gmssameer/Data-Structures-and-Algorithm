import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class GetYourGuide {

    public static class Photo {
        Integer index;
        String ext;
        String city;
        Date time;

        String name;
        Photo(int i , String s){
            try {
                this.index = i;
                this.name = "";
                String []ph = s.split(",");
                this.ext = ph[0].split("\\.")[1];
                this.city = ph[1].strip();
                this.time =  new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(ph[2]);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public String toString() {
            return this.name;
        }
    }

    public static String solution(String S) {
        // write your code in Java SE 8
        StringBuilder ans = new StringBuilder();

        String []in = S.split("\n");
        List <Photo> photos =  new ArrayList<>();

        for(int i=0;i<in.length;i++){
            photos.add(new Photo(i+1,in[i]));
        }


        HashMap<String,SortedSet<Photo>> groupByCity = new HashMap<>();

        for(Photo p : photos){
            if(groupByCity.containsKey(p.city)){
                SortedSet<Photo> temp = groupByCity.get(p.city);
                temp.add(p);
                groupByCity.put(p.city,temp);
            }else {
                SortedSet<Photo> pp = new TreeSet<Photo>(new Comparator<Photo>() {
                    @Override
                    public int compare(Photo t1, Photo t2) {
                        return t1.time.compareTo(t2.time);
                    }
                });
                pp.add(p);
                groupByCity.put(p.city,pp);
            }
        }

        SortedSet<Photo> sortByIndex = new TreeSet<>(new Comparator<Photo>() {
            @Override
            public int compare(Photo t1, Photo t2) {
                return t1.index.compareTo(t2.index);
            }
        });

        for(Map.Entry<String,SortedSet<Photo>>ppp : groupByCity.entrySet()){
//            System.out.println(ppp.getKey());
            SortedSet<Photo> sp = ppp.getValue();
//            sortByIndex.addAll(p);
            int size = sp.size();
            int count = 0;
            while (size != 0) {
                // num = num/10
                size /= 10;
                ++count;
            }
            String pad = "%0"+count+"d";
            int i =1;
            for(Photo p:sp){
                String formatted = String.format(pad,i);
                p.name = ppp.getKey()+formatted+"."+p.ext;
                sortByIndex.add(p);
                i++;
            }

        }


        for(Photo p : sortByIndex){
            ans.append(p.toString()).append("\n");
        }



        return ans.toString();
    }

    public static void main(String[] args) {
        String S = "photo.jpg, Warsaw, 2013-09-05 14:08:15\n" +
                "john.png, London, 2015-06-20 15:13:22\n" +
                "myFriends.png, Warsaw, 2013-09-05 14:07:13\n" +
                "Eiffel.jpg, Paris, 2015-07-23 08:03:02\n" +
                "pisatower.jpg, Paris, 2015-07-22 23:59:59\n" +
                "BOB.jpg, London, 2015-08-05 00:02:03\n" +
                "notredame.png, Paris, 2015-09-01 12:00:00\n" +
                "me.jpg, Warsaw, 2013-09-06 15:40:22\n" +
                "a.png, Warsaw, 2016-02-13 13:33:50\n" +
                "b.jpg, Warsaw, 2016-01-02 15:12:22\n" +
                "c.jpg, Warsaw, 2016-01-02 14:34:30\n" +
                "d.jpg, Warsaw, 2016-01-02 15:15:01\n" +
                "e.png, Warsaw, 2016-01-02 09:49:09\n" +
                "f.png, Warsaw, 2016-01-02 10:55:32\n" +
                "g.jpg, Warsaw, 2016-02-29 22:13:11";
        System.out.println("Ans: "+solution(S));
    }
}
