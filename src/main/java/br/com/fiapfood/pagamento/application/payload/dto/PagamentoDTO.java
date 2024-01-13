package br.com.fiapfood.pagamento.application.payload.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PagamentoDTO {

    private String id;
    private LocalDateTime dateCreated;
    private String dateApproved;
    private String dateLastUpdated;
    private String moneyReleaseDate;
    private String paymentMethodId;
    private String paymentTypeId;
    private String status;
    private String statusDetail;
    private String currencyId;
    private String description;
    private Long collectorId;
    private MedataDTO data;

    // private PayerDTO payer;
    // private Map<String, Object> metadata;
    // private Map<String, Object> additionalInfo;
    // private Double transactionAmount;
    // private Double transactionAmountRefunded;
    // private Double couponAmount;
    // private TransactionDetailsDTO transactionDetails;
    // private Integer installments;
    // private Map<String, Object> card;
}


