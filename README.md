# LP-API2


### Version
- jdk 21
- gradle 8.13 (https://docs.gradle.org/current/release-notes.html)
- spring boot 3.4.3
- kotlin: 1.9.22


## 아키텍처 요약
| 구성 요소       | 설명 |
|---------------|---------------------------------------------------|
| **Route 53**  | DNS 관리 및 API Gateway / ALB로 트래픽 라우팅 |
| **API Gateway / ALB** | API 요청을 ECS로 전달 및 로드 밸런싱 |
| **ECS Cluster (Fargate)** | 마이크로서비스 실행 환경 |
| **Fluent Bit (FireLens)** | 로그 수집 및 OpenSearch 전송 |
| **OpenSearch** | 로그 저장 및 분석 |
| **RDS (MySQL)** | 데이터베이스 |
| **Redis** | 캐싱 시스템 |
| **Kafka (MSK)** | 메시지 브로커 |
| **S3** | 이미지 및 파일 저장 |
| **CI/CD (ECR, CodePipeline)** | 컨테이너 배포 자동화 |
| **EC2 (Eureka, ConfigServer)** | 서비스 디스커버리 및 설정 관리 |

## 패키지구성
| 서비스         | 패키지명                |
|-------------|---------------------|
| **Demo**    | `com.skdnd.demo`    |
| **User**    | `com.skdnd.user`    |
| **Gateway** | `com.skdnd.gateway` |
| **Eureka**  | `com.skdnd.eureka`  |
| **Auth**    | `com.skdnd.auth`    |
| **Common**  | `com.skdnd.common`  |

```
src/main/kotlin/com/skdnd/user/
├── controller/      # API 컨트롤러
│   ├── UserController.kt
├── service/         # 비즈니스 로직
│   ├── UserService.kt
├── repository/      # 데이터베이스 접근
│   ├── UserRepository.kt
├── entity/          # JPA/Exposed Entity (DB 매핑)
│   ├── User.kt
├── dto/             # API 요청/응답 DTO
│   ├── UserRequest.kt
│   ├── UserResponse.kt
├── config/          # Spring 설정 관련
│   ├── DatabaseConfig.kt
│   ├── WebConfig.kt
├── exception/       # 예외 처리
│   ├── CustomException.kt
│   ├── GlobalExceptionHandler.kt
├── security/        # 인증/인가 (JWT, OAuth2)
│   ├── JwtUtil.kt
│   ├── SecurityConfig.kt
├── client/          # 다른 마이크로서비스 호출 (FeignClient)
│   ├── OrderServiceClient.kt
├── event/           # 이벤트 기반 비동기 처리 (Kafka, RabbitMQ)
│   ├── UserCreatedEvent.kt
│   ├── UserEventListener.kt
├── Application.kt   # Spring Boot 메인 실행 파일

```