
## 
| 서비스 | 패키지명 |
|--------|-----------|
| **Demo** | `com.skdnd.demo` |
| **User** | `com.skdnd.user` |
| **Gateway** | `com.skdnd.gateway` |
| **Eureka** | `com.skdnd.eureka` |
| **Common** | `com.skdnd.common` |

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