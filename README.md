# interact-solve
とある授業で悩み共有のためのWebアプリケーションが必要になったのでそのために作成中...

## 使い方
1. `$ git clone https://github.com/a171413/interact-solve.git` <br />
（ghqを使っている人は `$ ghq get https://github.com/a171413/inteeract-solve` ）
2. リポジトリ直下に`.env.sample` があるので同階層に複製（ファイル名は`.env`とする）したらポート番号等を指定する<br />
   PROJECT_NAME=interact-solve<br />
   DB_PORT=XXXX←お好きにどうぞ<br />
   APP_PORT=XXXX←お好きにどうぞ<br />
   DB_NAME=interact-solve
3. `$ cd リポジトリの場所` などでリポジトリのある場所に移動
4. `$ docker compose build` を実行
5. `$ docker compose up` を実行 
    ここでbindについての問題が生じた人はDockerの設定からResources/FILE SHARINGにgitフォルダ（ghqの人はghqフォルダ）を追加してDockerを再起動．<br />
   その後，プロジェクト/build/libsフォルダを作成すれば解消することが多い

上記でとりあえず接続できるはず
