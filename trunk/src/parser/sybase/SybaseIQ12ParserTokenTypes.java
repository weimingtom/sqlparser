// $ANTLR 2.7.7 (2006-11-01): "src/parser/sybase/parser_sybase.g" -> "SybaseIQ12Parser.java"$

	package parser.sybase;

public interface SybaseIQ12ParserTokenTypes {
	int EOF = 1;
	int NULL_TREE_LOOKAHEAD = 3;
	int SELECT_STATEMENT = 4;
	int SEARCH_NOT_CONDITION = 5;
	int SUBQUERY = 6;
	int GROUP_BY = 7;
	int ORDER_BY = 8;
	int ALIAS_EQU = 9;
	int FUNCTION = 10;
	int FUNCTION_ROWID = 11;
	int FUNCTION_NOTHING = 12;
	int FUNCTION_EMPTY_PARAM = 13;
	int FUNCTION_STAR_PARAM = 14;
	int FUNCTION_STAR_COUNT = 15;
	int FUNCTION_DATA_TYPE = 16;
	int FUNCTION_AS_DATA_TYPE = 17;
	int LOGIC_OP = 18;
	int LOGICAL_NULL = 19;
	int LOGICAL_NOT_NULL = 20;
	int LOGICAL_IN = 21;
	int LOGICAL_NOT_IN = 22;
	int LOGICAL_LIKE = 23;
	int LOGICAL_NOT_LIKE = 24;
	int LOGICAL_EXISTS = 25;
	int LOGICAL_NOT_EXISTS = 26;
	int LOGICAL_BETWEEN = 27;
	int SUBCONTAIN_OP = 28;
	int ALL_FIELDS = 29;
	int PAREN_FIELD = 30;
	int PAREN_DATA_TYPE = 31;
	int PAREN_CHAR_DATA_TYPE = 32;
	int LOGIC_BLOCK = 33;
	int COLUMN = 34;
	int WHERE = 35;
	int SEMI = 36;
	int TABLE_UNION_EN = 37;
	int TABLE_UNION_CN = 38;
	int COMMA = 39;
	int TABLE_COMPARE_EN = 40;
	int TABLE_COMPARE_CN = 41;
	int WHERE_EN = 42;
	int WHERE_CN = 43;
	int EXISTS_EN = 44;
	int EXISTS_CN = 45;
	int NOT_EXISTS_CN = 46;
	int NOT_EN = 47;
	int SELECT_EN = 48;
	int SELECT_CN = 49;
	int DISTINCT_EN = 50;
	int DISTINCT_CN = 51;
	int TOP_EN = 52;
	int TOP_CN = 53;
	int FROM_EN = 54;
	int FROM_CN = 55;
	int GROUP_EN = 56;
	int BY_EN = 57;
	int GROUP_BY_CN = 58;
	int ORDER_EN = 59;
	int ORDER_BY_CN = 60;
	int REAL_NUM = 61;
	int NOT_CN = 62;
	int AND_EN = 63;
	int OR_EN = 64;
	int AND_CN = 65;
	int OR_CN = 66;
	int LPAREN = 67;
	int RPAREN = 68;
	int AS_EN = 69;
	int AS_CN = 70;
	// "=" = 71
	// "\u7b49\u4e8e" = 72
	int SELECT_ALL_CN = 73;
	int STAR = 74;
	int ASC_EN = 75;
	int ASC_CN = 76;
	int DESC_EN = 77;
	int DESC_CN = 78;
	int LIKE_EN = 79;
	int LIKE_CN = 80;
	int NOT_LIKE_CN = 81;
	int IS_EN = 82;
	int NULL_EN = 83;
	int NULL_CN = 84;
	int NOT_NULL_CN = 85;
	int BETWEEN_CN = 86;
	int BETWEEN_EN = 87;
	int IN_EN = 88;
	int IN_CN = 89;
	int NOT_IN_CN = 90;
	int COUNT_EN = 91;
	int COUNT_CN = 92;
	int ALL_EN = 93;
	int ALL_CN = 94;
	int DATA_TYPE_AS_CN = 95;
	int CHAR = 96;
	int DATA_TYPE_STRING = 97;
	int ID = 98;
	int PARAM_ID = 99;
	int QUOTED_STRING = 100;
	int POINT = 101;
	int NEGATIVE_DIGIT_ELEMENT = 102;
	int LITERAL_avg = 103;
	// "\u6c42\u5e73\u5747\u6570" = 104
	int LITERAL_max = 105;
	// "\u6c42\u6700\u5927\u503c" = 106
	int LITERAL_min = 107;
	// "\u6c42\u6700\u5c0f\u503c" = 108
	int LITERAL_stddev = 109;
	// "\u6c42\u65b9\u5dee" = 110
	int LITERAL_sum = 111;
	// "\u6c42\u603b\u548c" = 112
	int LITERAL_variance = 113;
	// "\u6c42\u7edf\u8ba1\u65b9\u5dee" = 114
	int SYSDATE_EN = 115;
	int SYSDATE_CN = 116;
	int LITERAL_getdate = 117;
	// "\u53d6\u5f53\u524d\u65e5\u671f\u65f6\u95f42" = 118
	int LITERAL_rand = 119;
	// "\u53d6\u968f\u673a\u6570" = 120
	int LITERAL_dense_rank = 121;
	int LITERAL_percent_rank = 122;
	int LITERAL_rank = 123;
	int LITERAL_pi = 124;
	// "\u6c42\u5706\u5468\u7387" = 125
	int LITERAL_now = 126;
	// "\u53d6\u5f53\u524d\u65e5\u671f\u65f6\u95f41" = 127
	int LITERAL_today = 128;
	// "\u6c42\u5f53\u524d\u65e5\u671f" = 129
	int LITERAL_number = 130;
	// "\u53d6\u81ea\u589e\u5217" = 131
	int LITERAL_convert = 132;
	// "\u6570\u636e\u7c7b\u578b\u8f6c\u6362" = 133
	int LITERAL_cast = 134;
	// "\u6570\u636e\u7c7b\u578b\u8f6c\u5316" = 135
	int LITERAL_abs = 136;
	// "\u53d6\u7edd\u5bf9\u503c" = 137
	int LITERAL_acos = 138;
	// "\u6c42\u53cd\u4f59\u5f26\u503c" = 139
	int LITERAL_asin = 140;
	// "\u6c42\u53cd\u6b63\u5f26\u503c" = 141
	int LITERAL_atan = 142;
	// "\u6c42\u53cd\u6b63\u5207\u503c" = 143
	// "atin2" = 144
	// "\u6c42\u4e8c\u4e2a\u6570\u7684\u53cd\u6b63\u5207\u503c" = 145
	int LITERAL_ceiling = 146;
	// "\u53d6\u4e0a\u9650\u6574\u6570" = 147
	int LITERAL_cos = 148;
	// "\u6c42\u4f59\u5f26\u503c" = 149
	int LITERAL_cot = 150;
	// "\u6c42\u4f59\u5207\u503c" = 151
	int LITERAL_degrees = 152;
	// "\u5f27\u5ea6\u8f6c\u5ea6\u6570" = 153
	int LITERAL_exp = 154;
	// "\u6c42\u5e42\u503c" = 155
	int LITERAL_floor = 156;
	// "\u53d6\u4e0b\u9650\u6574\u6570" = 157
	int LITERAL_log = 158;
	// "\u6c42\u81ea\u7136\u5bf9\u6570" = 159
	// "log10" = 160
	// "\u6c4210\u4e3a\u5e95\u7684\u5bf9\u6570" = 161
	int LITERAL_mod = 162;
	// "\u6c42\u6a21" = 163
	int LITERAL_power = 164;
	// "\u6c42\u5e42" = 165
	int LITERAL_radians = 166;
	// "\u5ea6\u6570\u8f6c\u5f27\u5ea6" = 167
	int LITERAL_remainder = 168;
	// "\u6c42\u4f59" = 169
	int LITERAL_round = 170;
	// "\u683c\u5f0f\u5316\u6570\u503c" = 171
	int LITERAL_sign = 172;
	// "\u6c42\u503c\u7684\u7b26\u53f7" = 173
	int LITERAL_sin = 174;
	// "\u6c42\u6b63\u5f26\u503c" = 175
	int LITERAL_sqrt = 176;
	// "\u6c42\u5e73\u65b9\u6839" = 177
	int LITERAL_tan = 178;
	// "\u6c42\u6b63\u5207\u503c" = 179
	// "\u683c\u5f0f\u5316\u6570\u503c3" = 180
	int LITERAL_truncnum = 181;
	// "N\u4f4d\u7f6e\u96f6\u5904\u7406" = 182
	int LITERAL_ascii = 183;
	// "\u6c42ASCII\u7801" = 184
	int LITERAL_bit_length = 185;
	// "\u6c42\u5b57\u7b26\u4e32\u7684\u4e8c\u8fdb\u5236\u957f\u5ea6" = 186
	int LITERAL_byte_length = 187;
	// "\u6c42\u5b57\u7b26\u4e32\u7684\u5b57\u8282\u6570" = 188
	// "\u6c42\u7b49\u503c\u7684\u5b57\u7b26" = 189
	int LITERAL_char_length = 190;
	// "\u6c42\u5b57\u7b26\u4e32\u957f\u5ea61" = 191
	int LITERAL_charindex = 192;
	// "\u5b58\u5728\u4e8e" = 193
	int LITERAL_difference = 194;
	// "\u6c42\u4e24\u4e2a\u4e32\u7684\u58f0\u97f3\u5dee\u503c" = 195
	int LITERAL_insertstr = 196;
	// "\u63d2\u5165\u5b57\u7b26\u4e32" = 197
	int LITERAL_lcase = 198;
	// "\u8f6c\u4e3a\u5c0f\u5199\u5b57\u6bcd1" = 199
	int LITERAL_left = 200;
	// "\u5de6\u622a\u5b57\u7b26\u4e32" = 201
	int LITERAL_length = 202;
	// "\u6c42\u5b57\u7b26\u4e32\u957f\u5ea62" = 203
	int LITERAL_locate = 204;
	// "\u6c42\u4e32\u4f4d\u7f6e1" = 205
	int LITERAL_lower = 206;
	// "\u8f6c\u4e3a\u5c0f\u5199\u5b57\u6bcd2" = 207
	int LITERAL_ltrim = 208;
	// "\u53bb\u6389\u5de6\u7a7a\u683c" = 209
	int LITERAL_octet_length = 210;
	// "\u6c42\u5b57\u7b26\u4e32\u7684\u5b58\u50a8\u957f\u5ea6" = 211
	int LITERAL_patindex = 212;
	// "\u6c42\u4e32\u4f4d\u7f6e2" = 213
	int LITERAL_repeat = 214;
	// "\u5b57\u7b26\u4e32\u5faa\u73af\u8fde\u63a51" = 215
	int LITERAL_replace = 216;
	// "\u66ff\u6362\u5b57\u7b26\u4e32" = 217
	int LITERAL_replicate = 218;
	// "\u5b57\u7b26\u4e32\u5faa\u73af\u8fde\u63a52" = 219
	int LITERAL_right = 220;
	// "\u53f3\u622a\u5b57\u7b26\u4e32" = 221
	int LITERAL_rtrim = 222;
	// "\u53bb\u6389\u53f3\u7a7a\u683c" = 223
	int LITERAL_similar = 224;
	// "\u6c42\u5b57\u7b26\u4e32\u76f8\u4f3c\u5ea6" = 225
	int LITERAL_sortkey = 226;
	// "\u5b57\u7b26\u4e32\u6392\u5e8f" = 227
	int LITERAL_soundex = 228;
	// "\u6c42\u5b57\u7b26\u4e32\u58f0\u97f3\u503c" = 229
	int LITERAL_space = 230;
	// "\u586b\u7a7a\u683c" = 231
	int LITERAL_str = 232;
	// "\u6570\u503c\u8f6c\u5b57\u7b26\u4e32" = 233
	int LITERAL_string = 234;
	// "\u5b57\u7b26\u4e32\u5408\u5e76" = 235
	int LITERAL_stuff = 236;
	// "\u5b57\u7b26\u4e32\u5220\u9664\u66ff\u6362" = 237
	int LITERAL_substring = 238;
	// "\u5b57\u7b26\u4e32\u622a\u53d6" = 239
	int LITERAL_trim = 240;
	// "\u53bb\u5de6\u53f3\u7a7a\u683c" = 241
	int LITERAL_ucase = 242;
	// "\u8f6c\u4e3a\u5927\u5199\u5b57\u6bcd1" = 243
	int LITERAL_upper = 244;
	// "\u8f6c\u4e3a\u5927\u5199\u5b57\u6bcd2" = 245
	int LITERAL_dateformat = 246;
	// "\u683c\u5f0f\u5316\u65e5\u671f" = 247
	int LITERAL_datename = 248;
	// "\u6c42\u65e5\u671f\u5206\u91cf\u82f1\u6587\u540d" = 249
	int LITERAL_datepart = 250;
	// "\u6c42\u65e5\u671f\u7684\u5206\u91cf\u503c" = 251
	int LITERAL_datetime = 252;
	// "\u8f6c\u4e3a\u65e5\u671f\u65f6\u95f4" = 253
	int LITERAL_date = 254;
	// "\u8f6c\u4e3a\u65e5\u671f" = 255
	int LITERAL_dayname = 256;
	// "\u6c42\u661f\u671f\u82f1\u6587\u540d" = 257
	int LITERAL_days = 258;
	// "\u6c42\u5929\u6570" = 259
	int LITERAL_day = 260;
	// "\u6c42\u5177\u4f53\u65e5\u671f" = 261
	int LITERAL_dow = 262;
	// "\u6c42\u5177\u4f53\u661f\u671f" = 263
	int LITERAL_hours = 264;
	// "\u6c42\u5c0f\u65f6\u6570" = 265
	int LITERAL_hour = 266;
	// "\u6c42\u5177\u4f53\u5c0f\u65f6" = 267
	int LITERAL_minutes = 268;
	// "\u6c42\u5206\u949f\u6570" = 269
	int LITERAL_minute = 270;
	// "\u6c42\u5177\u4f53\u5206\u949f" = 271
	int LITERAL_monthname = 272;
	// "\u6c42\u6708\u4efd\u82f1\u6587\u540d" = 273
	int LITERAL_months = 274;
	// "\u6c42\u6708\u6570" = 275
	int LITERAL_month = 276;
	// "\u6c42\u5177\u4f53\u6708\u6570" = 277
	int LITERAL_quarter = 278;
	// "\u6c42\u5177\u4f53\u5b63\u5ea6" = 279
	int LITERAL_seconds = 280;
	// "\u6c42\u79d2\u6570" = 281
	int LITERAL_second = 282;
	// "\u6c42\u5177\u4f53\u79d2" = 283
	int LITERAL_weeks = 284;
	// "\u6c42\u5468\u6570" = 285
	int LITERAL_years = 286;
	// "\u6c42\u5e74\u6570" = 287
	int LITERAL_year = 288;
	// "\u6c42\u5177\u4f53\u5e74\u4efd" = 289
	int LITERAL_ymd = 290;
	// "\u6570\u503c\u8f6c\u65e5\u671f" = 291
	int LITERAL_dateadd = 292;
	// "\u65e5\u671f\u8fd0\u7b97" = 293
	int LITERAL_datediff = 294;
	// "\u6c42\u4e24\u65e5\u671f\u5dee\u503c" = 295
	int LITERAL_hextoint = 296;
	// "\u5341\u516d\u8fdb\u5236\u8f6c\u4e3a\u6574\u6570" = 297
	int LITERAL_inttohex = 298;
	// "\u6574\u6570\u8f6c\u4e3a\u5341\u516d\u8fdb\u5236" = 299
	int LITERAL_isdate = 300;
	// "\u662f\u5426\u65e5\u671f\u578b" = 301
	int LITERAL_isnumeric = 302;
	// "\u662f\u5426\u6570\u503c\u578b" = 303
	int LITERAL_suser_id = 304;
	int LITERAL_suser_name = 305;
	int LITERAL_user_id = 306;
	int LITERAL_user_name = 307;
	int LITERAL_rowid = 308;
	// "\u6c42\u884c\u53f7" = 309
	int LITERAL_ntile = 310;
	int LITERAL_percentile_count = 311;
	int LITERAL_percentile_desc = 312;
	int LITERAL_argn = 313;
	// "\u53d6\u7b2cn\u4e2a\u53d8\u91cf" = 314
	int LITERAL_coalesce = 315;
	// "\u53d6\u9996\u4e2a\u975e\u7a7a\u53d8\u91cf1" = 316
	int LITERAL_ifnull = 317;
	// "\u7a7a\u53d8\u91cf\u7f6e\u6362" = 318
	int LITERAL_isnull = 319;
	// "\u53d6\u9996\u4e2a\u975e\u7a7a\u53d8\u91cf2" = 320
	int LITERAL_nullif = 321;
	// "\u5224\u65ad\u53d8\u91cf\u662f\u5426\u76f8\u7b49" = 322
	int TILDE = 323;
	// "\u975e\u8fd0\u7b97" = 324
	// "\u4e0e" = 325
	// "\u6216" = 326
	// "\u5f02\u6216" = 327
	// "\u52a0" = 328
	// "\u51cf" = 329
	// "\u4e58" = 330
	// "\u9664" = 331
	int PLUS = 332;
	int MINUS = 333;
	int DIVIDE = 334;
	int MOD = 335;
	int AMPERSAND = 336;
	int BITWISEOR = 337;
	int BITWISEXOR = 338;
	int ASSIGNEQUAL = 339;
	// "\u5927\u4e8e\u7b49\u4e8e" = 340
	// "\u5c0f\u4e8e\u7b49\u4e8e" = 341
	// "\u5927\u4e8e" = 342
	// "\u5c0f\u4e8e" = 343
	// "\u4e0d\u7b49\u4e8e" = 344
	// "\u5de6\u8fde\u63a5" = 345
	int LEFT_JOIN = 346;
	int NOTEQUAL1 = 347;
	int NOTEQUAL2 = 348;
	int LESSTHANOREQUALTO1 = 349;
	int LESSTHANOREQUALTO2 = 350;
	int LESSTHAN = 351;
	int GREATERTHANOREQUALTO1 = 352;
	int GREATERTHANOREQUALTO2 = 353;
	int GREATERTHAN = 354;
	int LITERAL_yy = 355;
	int LITERAL_mm = 356;
	int LITERAL_dd = 357;
	int LITERAL_qq = 358;
	int LITERAL_week = 359;
	int LITERAL_wk = 360;
	int LITERAL_dayofyear = 361;
	int LITERAL_dy = 362;
	int LITERAL_weekday = 363;
	int LITERAL_dw = 364;
	int LITERAL_hh = 365;
	int LITERAL_mi = 366;
	int LITERAL_ss = 367;
	int LITERAL_millisecond = 368;
	int LITERAL_ms = 369;
	int LITERAL_calweekofyear = 370;
	int LITERAL_cwk = 371;
	int LITERAL_calyearofweek = 372;
	int LITERAL_cyr = 373;
	int LITERAL_caldayofweek = 374;
	int LITERAL_cdw = 375;
	int LITERAL_uniqueidentifierstr = 376;
	int LITERAL_bigint = 377;
	int LITERAL_int = 378;
	int LITERAL_integer = 379;
	int LITERAL_smallint = 380;
	int LITERAL_tinyint = 381;
	int LITERAL_double = 382;
	int LITERAL_real = 383;
	int LITERAL_smalldatetime = 384;
	int LITERAL_time = 385;
	int LITERAL_timestamp = 386;
	int LITERAL_bit = 387;
	int DOT_STAR = 388;
	int PARAM_LPAREN = 389;
	int PARAM_RPAREN = 390;
	int FROM = 391;
	int WS = 392;
	int ESC = 393;
	int ID_START_LETTER = 394;
	int ID_LETTER = 395;
	int NUM = 396;
	int DOT_NUM = 397;
	int NUM_START = 398;
	int NUM_LETTER = 399;
	int ML_COMMENT = 400;
	int COMPARE_OP = 401;
	int TWO_ARG_OP = 402;
	int ONE_ARG_OP = 403;
}
