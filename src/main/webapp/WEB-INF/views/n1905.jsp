<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<title>대한민국 교육계 친일인사 87명</title>
<link rel="shortcut icon" href="/resources/img/n1905/static/favicon.ico">
<link rel="stylesheet" href="/resources/css/n1905/style.css"> 
<script>
	$(function(){
		ajaxCallGet("/api/v1/n1905", function(res){
			var template = $.templates("#members"); // <!-- 템플릿 선언
	        var htmlOutput = template.render(res); // <!-- 렌더링 진행 -->
	        $("#graphBox").html(htmlOutput);
		})
	})
	
		$.views.converters("split0",
            function(val) {
              return val.split("|")[0]
            }
          );
	$.views.converters("split1",
            function(val) {
              return val.split("|")[1]
            }
          );
</script>
<script type="text/x-jsrender" id="members">
{{for data}}
					<div class="man">
						<div class="man-icon">
							<img src="{{:member_img}}" alt="" class="man-iconimg">
						</div> 
						<p class="man-name">{{:name}}</p> 
						<p class="man-text">{{:job}}</p>
					</div>
	

					<div class="infobox" style="display: none;">
						<img src="/resources/img/n1905/static/close.png" alt="닫기버튼" class="infobox-close"> 
						<img src="{{:member_img}}" alt="" class="infobox-iconimg"> 
						<p class="infobox-name">{{:name}}</p> 
						<p class="infobox-text">{{:job}}</p> 
						<p class="infobox-text">{{:years}}</p>
						{{if member_file}}
							<a href="{{:member_file}}" target="_blank" class="infobox-link">친일반민족규명위 결정보고서 보기</a>
						{{/if}}

						{{if detail_1}}
							<div class="infobox-mini">
								<p class="infobox-smtitle">{{split0:detail_1}}</p> 
								<p class="infobox-text">{{split1:detail_1}}</p>
							</div> 
						{{/if}}
						{{if detail_2}}
							<div class="infobox-mini">
								<p class="infobox-smtitle">{{split0:detail_2}}</p> 
								<p class="infobox-text">{{split1:detail_2}}</p>
							</div> 
						{{/if}}
						{{if detail_3}}
							<div class="infobox-mini">
								<p class="infobox-smtitle">{{split0:detail_3}}</p> 
								<p class="infobox-text">{{split1:detail_3}}</p>
							</div> 
						{{/if}}
						{{if detail_4}}
							<div class="infobox-mini">
								<p class="infobox-smtitle">{{split0:detail_4}}</p> 
								<p class="infobox-text">{{split1:detail_4}}</p>
							</div> 
						{{/if}}
					</div>
					
					
{{/for}}
</script>
<body>
    <header class="header">
        <a href="https://newstapa.org/" target="_blank">
            <img src="https://storage.googleapis.com/media.newstapa.org/static/bundle/korean/assets/img/logo.svg" alt="Newstapa logo" class="header__logo">
        </a>
    </header>
    
    
    
    <div class="section">
        <div class="border">
            <p class="webtitle">대한민국 교육계 친일인사 87명</p>
            <p class="paragraph">뉴스타파는 친일반민족행위진상규명위원회가 발표한 친일반민족행위자 1006명과 민족문제연구소가 발간한 친일인명사전에 등재된 친일인사 4천 3백여 명을 대상으로 이들이 해방 후 대한민국의 교육 분야에 어떤 행적을 남겼는지 조사했다. <br>중·고등·대학교 등 학교를 설립했거나 대학교 이상에서 법인이사, 이사장, 총장을 지닌 이력을 확인했다. <br>뉴스타파가 작성한 87명의 명단을 모두 공개한다. 각 인물 사진을 클릭하면 인물 세부정보를 볼 수 있다. </p>
            <div id="app">
				<div id="graphBox" class="canvas">
				</div>
			</div>
        </div>
    </div>
    
    
    
    
    <footer class="footer">
        <div class="footer__box">
            <img src="https://storage.googleapis.com/media.newstapa.org/static/bundle/korean/assets/img/logo-bright.svg" alt="logo white version" class="footer__logo">
            <div class="footer__info">
                <div class="footer__info__margin">
                    <ul>
                        <li>
                            <a href="https://jebo.newstapa.org">제보</a>
                            <span class="sep">|</span>
                        </li>
                        <li>
                            <a href="https://goo.gl/forms/qSkAChcxDfPNcsgj2">인터뷰, 강의, 견학 요청</a>
                            <span class="sep">|</span>
                        </li>
                        <li>
                            <a href="https://kcij.org/contact">제휴, 협력 문의</a>
                            <span class="sep">|</span>
                        </li>
                        <li>
                            <a href="https://download.newstapa.org/common/html/terms5.html">청소년 보호정책</a>
                            <span class="sep">|</span>
                        </li>
                        <li>
                            <a href="https://kcij.org/faq">자주 묻는 질문(FAQ)</a>
                            <span class="sep">|</span>
                        </li>
                        <li>
                            <a href="https://newstapa.org/using">콘텐츠 사용원칙</a>
                        </li>
                    </ul>
                </div>
                <div class="footer__info__margin">
                    <p>서울특별시 중구 세종대로19길 16 성공회빌딩 3층 (04519)</p>
                    <p>사업자등록번호 : 117-82-66835 | 인터넷신문등록번호 : 서울,아02778 (2013년 8월 21일)</p>
                    <p>대표자: 김용진 | 발행인/편집인:김용진 | 개인정보관리 책임자 : 김성근</p>
                    <p>Tel 02-2038-0977 | 제보 02-2038-8029 | FAX 02-2038-0978 | webmaster@newstapa.org</p>
                </div>
                <div class="footer__info__margin">
                    <p>Copyright © 2019 KCIJ, All Rights Reserved.</p>
                </div>
            </div>
            <div class="footer__keep">
                <div class="footer__social">
                    <ul>
                        <li>
                            <a href="https://www.facebook.com/NEWSTAPA">
                                <img src="https://storage.googleapis.com/media.newstapa.org/static/bundle/korean/assets/img/social/icon-follow-facebook.svg" alt="facebook logo">
                            </a>
                        </li>
                        <li>
                            <a href="https://twitter.com/newstapa">
                                <img src="https://storage.googleapis.com/media.newstapa.org/static/bundle/korean/assets/img/social/icon-follow-twitter.svg" alt="twitter logo">
                            </a>
                        </li>
                        <li>
                            <a href="https://story.kakao.com/ch/newstapa">
                                <img src="https://storage.googleapis.com/media.newstapa.org/static/bundle/korean/assets/img/social/icon-follow-kakaostory.svg" alt="kakaostory logo">
                            </a>
                        </li>
                        <li>
                            <a href="https://www.youtube.com/user/newstapa">
                                <img src="https://storage.googleapis.com/media.newstapa.org/static/bundle/korean/assets/img/social/icon-follow-youtube.svg" alt="youtube logo">
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </footer>
	<script>
	$(function(){		
		$(document).on("click", ".man-icon", function(){
			
			$(this).parent().next().css('display','block');
			
		});
		$(document).on("click", ".infobox-close", function(){
			$(".infobox").css('display','none');
		});	
	});
	</script>
</body>
</html>
