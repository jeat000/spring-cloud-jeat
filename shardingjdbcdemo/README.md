Sharding-JDBC: 数据库任意

goods_db 为普通 表查询 垂直拆分
goods_db_1 为水平分片的库
goods_db_2 为水平分片的库

直接对 goods 表查询，插入，新增 可对于 gid 分片，数据库中 实际表名为  goods_1  goods_2

详细配置请见yml配置项
分片后事务，分片后关联查询  可见 单元测试

分片算法官网：https://shardingsphere.apache.org/document/current/cn/user-manual/shardingsphere-jdbc/configuration/built-in-algorithm/sharding/

底层原理改写sql
sharding-jdbc  
    ├── sharding-jdbc-core      重写DataSource/Connection/Statement/ResultSet四大对象
    └── sharding-jdbc-orchestration        配置中心
sharding-core
    ├── sharding-core-api       接口和配置类	
    ├── sharding-core-common    通用分片策略实现...
    ├── sharding-core-entry     SQL解析、路由、改写，核心类BaseShardingEngine
    ├── sharding-core-route     SQL路由，核心类StatementRoutingEngine
    ├── sharding-core-rewrite   SQL改写，核心类ShardingSQLRewriteEngine
    ├── sharding-core-execute   SQL执行，核心类ShardingExecuteEngine
    └── sharding-core-merge     结果合并，核心类MergeEngine
shardingsphere-sql-parser 
    ├── shardingsphere-sql-parser-spi       SQLParserEntry，用于初始化SQLParser
    ├── shardingsphere-sql-parser-engine    SQL解析，核心类SQLParseEngine
    ├── shardingsphere-sql-parser-relation
    └── shardingsphere-sql-parser-mysql     MySQL解析器，核心类MySQLParserEntry和MySQLParser
shardingsphere-underlying           基础接口和api
    ├── shardingsphere-rewrite      SQLRewriteEngine接口
    ├── shardingsphere-execute      QueryResult查询结果
    └── shardingsphere-merge        MergeEngine接口
shardingsphere-spi                  SPI加载工具类
sharding-transaction
    ├── sharding-transaction-core   接口ShardingTransactionManager，SPI加载		
    ├── sharding-transaction-2pc    实现类XAShardingTransactionManager
    └── sharding-transaction-base   实现类SeataATShardingTransactionManager

@RequiredArgsConstructor
@Getter
public abstract class AbstractSQLBuilder implements SQLBuilder {
    
    private final SQLRewriteContext context;
    
    @Override
    public final String toSQL() {
        if (context.getSqlTokens().isEmpty()) {
            return context.getSql();
        }
        Collections.sort(context.getSqlTokens());
        StringBuilder result = new StringBuilder();
        result.append(context.getSql().substring(0, context.getSqlTokens().get(0).getStartIndex()));
        for (SQLToken each : context.getSqlTokens()) {
            result.append(getSQLTokenText(each));
            result.append(getConjunctionText(each));
        }
        return result.toString();
    }
}


DROP TABLE IF EXISTS `goods_1`;
CREATE TABLE `goods_1`  (
  `gid` int NOT NULL,
  `gname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `user_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `gstatus` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`gid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

DROP TABLE IF EXISTS `goods_2`;
CREATE TABLE `goods_2`  (
  `gid` int NOT NULL,
  `gname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `user_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `gstatus` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`gid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint NOT NULL,
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;