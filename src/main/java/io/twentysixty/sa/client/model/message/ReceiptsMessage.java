package io.twentysixty.sa.client.model.message;

import java.util.List;

public class ReceiptsMessage extends BaseMessage {

	public List<MessageReceiptOptions> receipts;

	public List<MessageReceiptOptions> getReceipts() {
		return receipts;
	}

	public void setReceipts(List<MessageReceiptOptions> receipts) {
		this.receipts = receipts;
	}
	
}
