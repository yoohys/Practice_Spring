package guestbook.service;

import java.util.List;

import guestbook.model.Message;

public class MessageListView {

	private int messageTotalCount;
	private int CurrentPageNumber;
	private List<Message> messageList;
	private int pageTotalCount;
	private int messageCountPerPage;
	private int firstRow;
	private int endRow;

	public MessageListView(List<Message> messageList, int messageTotalCount, int currentPageNumber,
			int messageCountPerPage, int startRow, int endRow) {
		this.messageList = messageList;
		this.messageTotalCount = messageTotalCount;
		this.messageCountPerPage = messageCountPerPage;
		this.firstRow = startRow;
		this.endRow = endRow;

		calculatePageTotalCount();
	}

	private void calculatePageTotalCount() {
		if (messageTotalCount == 0) {
			pageTotalCount = 0;
		} else {
			pageTotalCount = messageTotalCount / messageCountPerPage;
			if (messageTotalCount % messageCountPerPage > 0) {
				pageTotalCount++;
			}
		}

	}

	public int getMessageTotalCount() {
		return messageTotalCount;
	}

	public int getCurrentPageNumber() {
		return CurrentPageNumber;
	}

	public List<Message> getmessageList() {
		return messageList;
	}

	public int getpageTotalCount() {
		return pageTotalCount;
	}

	public int getmessageCountPerPage() {
		return messageCountPerPage;
	}

	public int getfirstRow() {
		return firstRow;
	}

	public int getendRow() {
		return endRow;
	}

	public boolean isEmpty() {
		return messageTotalCount == 0;
	}

}
