package com.christoper.jin.web.board.domain.stock;

import com.christoper.jin.web.board.constant.stock.corporation.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

/**
 * @Class Corporation
 * @Description
 * @Author hyungeun.jin
 * @Since 2020. 4. 19.
 * @Version 1.0
 * @COPYRIGHT © WADIZ ALL RIGHTS RESERVED.
 * ------------------------------------------------------------------------
 * Modification Information
 * ------------------------------------------------------------------------
 * 수정일 || 수정자 || 수정내용
 * ------------------------------------------------------------------------
 * 2020. 4. 19. || 진형은 || 최초생성
 */
@Getter
@NoArgsConstructor
@Entity
public class Corporation {
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Long id;

  @Column(name="corporation_code")
  private String corporationCode;
  private String name;
  private String nameByTrade;
  private String nameByEnglish;

  @Enumerated(EnumType.STRING)
  private Type type;//유형

  @Enumerated(EnumType.STRING)
  private Scale scale;//규모

  private LocalDateTime graduatedDate;

  @Enumerated(EnumType.STRING)
  private Shape shape;//형태코드

  @Enumerated(EnumType.STRING)
  private EstablishedShape establishedShape;//설립형태

  @Enumerated(EnumType.STRING)
  private Status status;

  private LocalDateTime statusChangedDate;//상태변경일자

  @Enumerated(EnumType.STRING)
  private GovernmentDivision governmentDivision;//공공기관구분

  private Boolean isVenture;

  private String industryCodeBy10;//업종코드(표준산업분류 10차)
  private String industryCodeBy9;//업종코드(표준산업분류 9차)

  @Enumerated(EnumType.STRING)
  private FinanceIndustry financeIndustry;//재무코드

  private String groupCode;
  private String groupName;
  private String businessRegNumber;//사업자등록번호
  private String corporationRegNumber;//법인번호
  private LocalDateTime establishDate;//설립일

  @Enumerated(EnumType.STRING)
  private Open openCode;//공개코드

  private String tradeRegNumber;//무역업신고번호

  private LocalDateTime listingDate;//상장 일자
  private LocalDateTime deListingDate;//상장폐지 일자

  private String majorBankCode;
  private String majorBankName;
  private String bankCode;
  private String bankName;
  private String settlementDate;//결산기준(월일)

  private String homepageUrl;
  private String email;

  private LocalDateTime reportDate;

  private String postCode;
  private String location;
  private String locationDetail;

  private String phoneNumber;
  private String faxNumber;

  private Integer workforce;

  private String productName;

  private String referenceCorporationCode;
  private LocalDateTime referenceCorporationEstablishDate;

  @OneToMany(mappedBy="corporation")
  private List<Financial> financialList = new LinkedList<>();

  @Builder
  public Corporation(String corporationCode,
                     String name, String nameByTrade, String nameByEnglish,
                     Type type, Scale scale, LocalDateTime graduatedDate,
                     Shape shape, EstablishedShape establishedShape, Status status, LocalDateTime statusChangedDate,
                     GovernmentDivision governmentDivision, Boolean isVenture,
                     String industryCodeBy10, String industryCodeBy9, FinanceIndustry financeIndustry,
                     String groupCode, String groupName,
                     String businessRegNumber, String corporationRegNumber,
                     LocalDateTime establishDate,
                     Open openCode,
                     String tradeRegNumber,
                     LocalDateTime listingDate, LocalDateTime deListingDate,
                     String majorBankCode, String majorBankName, String bankCode, String bankName, String settlementDate,
                     String homepageUrl, String email,
                     LocalDateTime reportDate,
                     String postCode, String location, String locationDetail,
                     String phoneNumber, String faxNumber,
                     Integer workforce,
                     String productName,
                     String referenceCorporationCode, LocalDateTime referenceCorporationEstablishDate){
    this.corporationCode = corporationCode;

    this.name = name;
    this.nameByTrade = nameByTrade;
    this.nameByEnglish = nameByEnglish;

    this.type = type;
    this.scale = scale;
    this.graduatedDate = graduatedDate;

    this.shape = shape;
    this.establishedShape = establishedShape;
    this.status = status;
    this.statusChangedDate = statusChangedDate;

    this.governmentDivision = governmentDivision;
    this.isVenture = isVenture;
    this.industryCodeBy10 = industryCodeBy10;
    this.industryCodeBy9 = industryCodeBy9;
    this.financeIndustry = financeIndustry;

    this.groupCode = groupCode;
    this.groupName = groupName;

    this.businessRegNumber = businessRegNumber;
    this.corporationRegNumber = corporationRegNumber;
    this.establishDate = establishDate;

    this.openCode = openCode;
    this.tradeRegNumber = tradeRegNumber;

    this.listingDate = listingDate;
    this.deListingDate = deListingDate;

    this.majorBankCode = majorBankCode;
    this.majorBankName = majorBankName;
    this.bankCode = bankCode;
    this.bankName = bankName;
    this.settlementDate = settlementDate;

    this.homepageUrl = homepageUrl;
    this.email = email;

    this.reportDate = reportDate;

    this.postCode = postCode;
    this.location = location;
    this.locationDetail = locationDetail;

    this.phoneNumber = phoneNumber;
    this.faxNumber = faxNumber;

    this.workforce = workforce;
    this.productName = productName;
    this.referenceCorporationCode = referenceCorporationCode;
    this.referenceCorporationEstablishDate = referenceCorporationEstablishDate;
  }
}
