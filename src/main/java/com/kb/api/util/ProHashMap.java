package com.kb.api.util;

import java.io.Serializable;
import java.util.HashMap;

public class ProHashMap extends HashMap<String, Object> implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int pg = 1;
	int page_block = 10;
	int page = 1;
	
	
	
	

	private int firstPageNo; // 첫 번째 페이지 번호
	private int prevPageNo; // 이전 페이지 번호
	private int startPageNo; // 시작 페이지 (페이징 네비 기준)
	private int endPageNo; // 끝 페이지 (페이징 네비 기준)
	private int nextPageNo; // 다음 페이지 번호
	private int finalPageNo; // 마지막 페이지 번호
	private int totalCount; // 게시글 전체 수
	private int blockSize = 5; // 페이지 번호 링크 개수
	private int startRowNum; // 게시글 조회 쿼리에 들어갈 row 시작점
	private int endRowNum; // 게시글 조회 쿼리에 들어갈 row 끝점



	public int getFirstPageNo() {
		return firstPageNo;
	}

	public void setFirstPageNo(int firstPageNo) {
		this.firstPageNo = firstPageNo;
	}

	public int getPrevPageNo() {
		return prevPageNo;
	}

	public void setPrevPageNo(int prevPageNo) {
		this.prevPageNo = prevPageNo;
	}

	public int getStartPageNo() {
		return startPageNo;
	}

	public void setStartPageNo(int startPageNo) {
		this.startPageNo = startPageNo;
	}


	public int getEndPageNo() {
		return endPageNo;
	}

	public void setEndPageNo(int endPageNo) {
		this.endPageNo = endPageNo;
	}

	public int getNextPageNo() {
		return nextPageNo;
	}

	public void setNextPageNo(int nextPageNo) {
		this.nextPageNo = nextPageNo;
	}

	public int getFinalPageNo() {
		return finalPageNo;
	}

	public void setFinalPageNo(int finalPageNo) {
		this.finalPageNo = finalPageNo;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		this.makePaging();
	}
	
	public int getBlockSize() {
		return blockSize;
	}

	public void setBlockSize(int blockSize) {
		this.blockSize = blockSize;
	}
	
	public int getStartRowNum() {
		return startRowNum;
	}

	public void setStartRowNum(int startRowNum) {
		this.startRowNum = startRowNum;
	}

	public int getEndRowNum() {
		return endRowNum;
	}

	public void setEndRowNum(int endRowNum) {
		this.endRowNum = endRowNum;
	}

	private void makePaging() {
		if (this.totalCount == 0)
			return; // 게시글 전체 수가 없는 경우
		if (this.page == 0)
			this.setPage(1); // 기본 값 설정
		if (this.page_block == 0)
			this.setPage_block(10); // 기본 값 설정

		int finalPage = (totalCount + (page_block - 1)) / page_block; // 마지막 페이지
		if (this.page > finalPage)
			this.setPage(finalPage); // 기본 값 설정

		if (this.page < 0 || this.page > finalPage)
			this.page = 1; // 현재 페이지 유효성 체크

		boolean isNowFirst = page == 1 ? true : false; // 시작 페이지 (전체)
		boolean isNowFinal = page == finalPage ? true : false; // 마지막 페이지 (전체)

		int startPage = ((page - 1) / blockSize) * blockSize + 1; // 시작 페이지 (페이징 네비 기준)
		int endPage = startPage + blockSize - 1; // 끝 페이지 (페이징 네비 기준)

		if (endPage > finalPage) { // [마지막 페이지 (페이징 네비 기준) > 마지막 페이지]보다 큰 경우
			endPage = finalPage;
		}

		this.setFirstPageNo(1); // 첫 번째 페이지 번호

		if (isNowFirst) {
			this.setPrevPageNo(1); // 이전 페이지 번호
		} else {
			this.setPrevPageNo(((page - 1) < 1 ? 1 : (page - 1))); // 이전 페이지 번호
		}

		this.setStartPageNo(startPage); // 시작 페이지 (페이징 네비 기준)
		this.setEndPageNo(endPage); // 끝 페이지 (페이징 네비 기준)

		if (isNowFinal) {
			this.setNextPageNo(finalPage); // 다음 페이지 번호
		} else {
			this.setNextPageNo(((page + 1) > finalPage ? finalPage : (page + 1))); // 다음 페이지 번호
		}

		this.setFinalPageNo(finalPage); // 마지막 페이지 번호
	}
	
	
	
	

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
		this.setEndRowNum(page * page_block);
		this.setStartRowNum(endRowNum - (page_block - 1));	
	}

	public int getPg() {
		return pg;
	}
	
	public void setPg(int pg) {
		this.pg = pg;
	}


	public int getPage_block() {
		return page_block;
	}

	public void setPage_block(int page_block) {
		this.page_block = page_block;
	}
	public HashMap<String, Object> getPageIngObj() {
		HashMap<String, Object> pageing = new HashMap<String, Object>();
		pageing.put("prevPageNo", getPrevPageNo());
		pageing.put("nextPageNo", getNextPageNo());
		pageing.put("startPageNo", getStartPageNo());
		pageing.put("endPageNo", getEndPageNo());
		pageing.put("page", getPage());
		return pageing;
	}
}
