package io.twentysixty.sa.client.model.message;

import java.io.Serializable;
import java.util.List;

public class ReceiptsMessage extends BaseMessage implements Serializable {

  private static final long serialVersionUID = -7697839170763910025L;
  public List<MessageReceiptOptions> receipts;

  public List<MessageReceiptOptions> getReceipts() {
    return receipts;
  }

  public void setReceipts(List<MessageReceiptOptions> receipts) {
    this.receipts = receipts;
  }
}
