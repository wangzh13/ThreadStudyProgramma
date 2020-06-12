package thread.sortpicture;

import java.util.LinkedList;

/**
 * @Description  ：排序图片相关Demo
 * @author       : 王作虎
 */
public class SortPictureMain {

    public static void main(String[] args) {

        LinkedList<SortPicture> linkedList  = new LinkedList();
        LinkedList<String> linkedList2  = new LinkedList();

        SortPicture SortPicture = new SortPicture();
        SortPicture SortPicture1 = new SortPicture();
        SortPicture SortPicture2 = new SortPicture();
        SortPicture SortPicture3 = new SortPicture();
        SortPicture SortPicture4 = new SortPicture();
        SortPicture SortPicture5 = new SortPicture();

        SortPicture.setUrlType("3");
        SortPicture.setUrlName("副图");

        SortPicture1.setUrlType("3");
        SortPicture1.setUrlName("副图");

        SortPicture2.setUrlType("3");
        SortPicture2.setUrlName("副图");

        SortPicture3.setUrlType("1");
        SortPicture3.setUrlName("主图");

        SortPicture4.setUrlType("3");
        SortPicture4.setUrlName("副图");

        SortPicture5.setUrlType("2");
        SortPicture5.setUrlName("小视频");

        linkedList.add(SortPicture);
        linkedList.add(SortPicture1);
        linkedList.add(SortPicture2);
        linkedList.add(SortPicture3);
        linkedList.add(SortPicture4);
        linkedList.add(SortPicture5);

        for (SortPicture SortPicture6:linkedList){

            if (SortPicture6.getUrlType().equals("1")&&!SortPicture6.getUrlType().equals("2")){
                linkedList2.addFirst(SortPicture6.getUrlName());
            }else if (SortPicture6.getUrlType().equals("3")&&!SortPicture6.getUrlType().equals("2")){
                linkedList2.add(SortPicture6.getUrlName());
            }
        }

        for (String urlName:linkedList2){

            System.out.println(urlName);
        }

    }
}
