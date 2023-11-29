package com.server.tori.dto.Guide;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class GuideResponseDto {

  private List<GuideValueDto> A_course;
  private List<GuideValueDto> B_course;
  private List<GuideValueDto> C_course;
  private List<GuideValueDto> D_course;
  private List<GuideValueDto> E_course;
  private List<GuideValueDto> F_course;
  private List<GuideValueDto> G_course;
  private List<GuideValueDto> H_course;
  private List<GuideValueDto> I_course;
  private List<GuideValueDto> J_course;
  private List<GuideValueDto> K_course;
  private List<GuideValueDto> L_course;

  // private Map<int,List<GuideValueDto>> 확장성 생각해보기

  public GuideResponseDto(List<GuideValueDto> A_course, List<GuideValueDto> B_course, List<GuideValueDto> C_course,
                          List<GuideValueDto> D_course, List<GuideValueDto> E_course, List<GuideValueDto> F_course,
                          List<GuideValueDto> G_course, List<GuideValueDto> H_course, List<GuideValueDto> I_course,
                          List<GuideValueDto> J_course, List<GuideValueDto> K_course, List<GuideValueDto> L_course) {

    this.A_course = A_course;
    this.B_course = B_course;
    this.C_course = C_course;
    this.D_course = D_course;
    this.E_course = E_course;
    this.F_course = F_course;
    this.G_course = G_course;
    this.H_course = H_course;
    this.I_course = I_course;
    this.J_course = J_course;
    this.K_course = K_course;
    this.L_course = L_course;

  }



  }

