# Crosby's Device Identifier Library

### Based on https://github.com/MatthewKing/DeviceId

### Example Code:
```java
public String generateIdentifier() {
    DeviceIdentifier identifier = DeviceIdentifier.builder()
        .addAccountName()
        .addOs()
        .format(DigestUtils::sha256hex)
        .build();
    
    return identifier.get();
}
```