package ljhproject.ljhproject.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageDto {

    private int nowPage;
    private int startPage;
    private int endPage;
    private int total;
    private int lastPage;
    private int start;
    private int end;
    private int cntPage = 5;
    private int cntPerPage;

    public PageDto(){ }

    public PageDto(int total, int nowPage, int cntPerPage){
        this.nowPage = nowPage;
        setNowPage(nowPage);
        setTotal(total);
        setCntPerPage(cntPerPage);
        calcLastPage(total, cntPerPage);
        Paging(getNowPage(), cntPage);

    }

    public void calcLastPage(int total, int cntPerPage) {
        setLastPage((int) Math.ceil((double)total / (double)cntPerPage));
    }

    public void Paging(int nowPage, int cntPage) {


        setStartPage(nowPage / cntPage * cntPage + 1);

        if (nowPage % cntPage == 0) {

            setStartPage(startPage -= cntPage);
        }


        setEndPage(startPage + cntPage - 1);

        if (endPage > lastPage) {
            setEndPage(endPage = lastPage);
        }
    }



}
