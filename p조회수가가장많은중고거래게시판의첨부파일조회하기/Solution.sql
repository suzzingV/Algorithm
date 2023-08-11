SELECT CONCAT('/home/grep/src/', F.BOARD_ID, '/', FILE_ID, FILE_NAME, FILE_EXT) AS FILE_PATH
FROM USED_GOODS_FILE AS F
WHERE F.BOARD_ID = (SELECT B.BOARD_ID
                    FROM USED_GOODS_BOARD AS B
                    WHERE B.VIEWS = (SELECT MAX(BB.VIEWS) FROM USED_GOODS_BOARD AS BB))
ORDER BY F.FILE_ID DESC