# コードフォーマット
format:
	./gradlew ktlintFormat

# リント チェック
lint:
	./gradlew ktlintCheck

# テスト実行
test:
	./gradlew test

# 特定のテストを実行
test-abs:
	./gradlew test --tests "abs.*"

# ビルド
build:
	./gradlew build

# クリーンビルド
clean:
	./gradlew clean

# すべてのチェック（フォーマット → リント → テスト）
check: format lint test

# 開発サイクル（よく使うコマンドをまとめる）
dev: format test